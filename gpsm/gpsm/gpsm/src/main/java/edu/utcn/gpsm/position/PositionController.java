package edu.utcn.gpsm.position;


import edu.utcn.gpsm.position.security.AuthRequest;
import edu.utcn.gpsm.position.security.AuthResponse;
import edu.utcn.gpsm.position.security.JwtUtil;
import edu.utcn.gpsm.position.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.io.PipedOutputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author Radu Miron
 * @since 15.10.2019
 */
@RestController
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwTokenUtil;

    @PostMapping("/createPosition")
    public PositionDTO create(@RequestBody PositionDTO positionDTO) {

        return positionService.create(positionDTO);
    }
    @RequestMapping("/getPosition/{positionId}")
    public PositionDTO getPositionById(@RequestParam Integer positionId) throws Exception {
        return positionService.getPositionById(positionId);
    }
    @DeleteMapping("/deletePosition/{positionId}")
    public void deletePositionById(@RequestParam Integer positionId) throws Exception {
       positionService.deletePositionById(positionId);
    }
    @GetMapping("/ALLposition")
    public List<PositionDTO> getAllPositions()
    {
        return positionService.getAllPositions();
    }

    @PutMapping("/updatePosition/{positionId}")
    public PositionDTO updatePosition(@RequestBody PositionDTO positionDTO) throws Exception {
        return positionService.updatePosition(positionDTO);
    }
    @GetMapping("/getByTerminalID/{terminalID}")
    public  List<PositionDTO>getAllByTerminalId(@RequestParam String terminalID) throws Exception {
        return positionService.getAllByTerminalId(terminalID);
    }
    @CrossOrigin
    @GetMapping("/getAllByTerminalIdAndCreationTimeBetween")
    public  List<PositionDTO>getAllByTerminalIdAndCreationTimeBetween(@RequestParam String terminalID, @RequestParam String date1,@RequestParam String date2) throws Exception {
        return positionService.getAllByTerminalIdAndCreationTimeBetween(terminalID,date1,date2);
    }
    @CrossOrigin
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authenticationReq)throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationReq.getUsername(), authenticationReq.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("incorrect user and pass", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationReq.getUsername());

        final String jwt = jwTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthResponse(jwt));

    }

}



