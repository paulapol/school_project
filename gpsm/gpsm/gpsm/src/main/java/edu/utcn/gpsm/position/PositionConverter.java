package edu.utcn.gpsm.position;



import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PositionConverter {

    public PositionDTO convertEntityToDto(Position position) {

        return new PositionDTO(position);
    }
    public Position convertDtoToEntity(PositionDTO positionDTO) {
        return new Position(positionDTO.getCreationTime(),
                        positionDTO.getTerminalId(),
                        positionDTO.getLatitude(),
                        positionDTO.getLongitude());
    }
}
