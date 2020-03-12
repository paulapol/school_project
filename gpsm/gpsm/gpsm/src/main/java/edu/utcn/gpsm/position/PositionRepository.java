package edu.utcn.gpsm.position;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

/**
 * @author Radu Miron
 * @since 15.10.2019
 */
public interface PositionRepository extends CrudRepository<Position, Integer> {

    List<Position> getAllByTerminalId(String terminalID);
    boolean existsByTerminalId(String terminalID);

    List<Position> getAllByTerminalIdAndCreationTimeBetween(String string,Date date,Date date2);

}

