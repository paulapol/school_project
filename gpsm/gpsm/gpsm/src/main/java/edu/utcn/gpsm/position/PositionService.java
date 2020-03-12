package edu.utcn.gpsm.position;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author Radu Miron
 * @since 15.10.2019
 */
@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;
    @Autowired
    private PositionConverter positionConverter;


    public PositionDTO create(PositionDTO positionDTO) {

        return positionConverter.convertEntityToDto(positionRepository.save(positionConverter.convertDtoToEntity(positionDTO)));
    }

    public List<PositionDTO> getAllPositions() {

        List<Position> positions= (List<Position>) positionRepository.findAll();
        List<PositionDTO> positionDTOS=new ArrayList<>();
        for(Position position:positions)
        {
            positionDTOS.add(positionConverter.convertEntityToDto(position));
        }

        return  positionDTOS;
    }

    public PositionDTO updatePosition(PositionDTO positionDTO) throws Exception {
        if (!positionRepository.existsById(positionDTO.getId())) {
            throw new Exception("Position id '" + positionDTO.getId() + "' does not exist");
        }
        Position position = positionRepository.findById(positionDTO.getId()).orElse(null);
        position.setLatitude(positionDTO.getLatitude());
        position.setLongitude(positionDTO.getLongitude());
        position.setCreationTime(positionDTO.getCreationTime());
        position.setLongitude(positionDTO.getLongitude());
        position.setTerminalId(positionDTO.getTerminalId());
        positionRepository.save(position);

        return positionConverter.convertEntityToDto(position);
    }
    public PositionDTO getPositionById(Integer id) throws Exception {
        if (!positionRepository.existsById(id)) {
            throw new Exception("Position id '" + id + "' does not exist");
        }
        return positionConverter.convertEntityToDto(positionRepository.findById(id).orElse(null));
    }
    public void deletePositionById(Integer id) throws Exception {
        if (!positionRepository.existsById(id)) {
            throw new Exception("Position id '" + id + "' does not exist");
        }
        positionRepository.deleteById(id);
    }
    public List<PositionDTO> getAllByTerminalId(String terminalID) throws Exception {
        if (!positionRepository.existsByTerminalId(terminalID)) {
            throw new Exception("Terminal id '" + terminalID + "' does not exist");
        }
        List<Position>positions= positionRepository.getAllByTerminalId(terminalID);
        List<PositionDTO> positionDTOS=new ArrayList<>();
        for(Position position:positions)
            positionDTOS.add(positionConverter.convertEntityToDto(position));
        return positionDTOS;
    }
    public List<PositionDTO> getAllByTerminalIdAndCreationTimeBetween(String terminalID, String firstd, String finald) throws Exception {
        if (!positionRepository.existsByTerminalId(terminalID)) {
            throw new Exception("Terminal id '" + terminalID + "' does not exist");
        }
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start=null,end=null;
        try {
            start=dateFormat.parse(firstd);
            end=dateFormat.parse(finald);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        List<Position> positions=positionRepository.getAllByTerminalIdAndCreationTimeBetween(terminalID,start,end);
        List<PositionDTO> positionDTOS=new ArrayList<>();
        for (Position position:positions)
            positionDTOS.add(positionConverter.convertEntityToDto(position));

        return positionDTOS;
    }
}
