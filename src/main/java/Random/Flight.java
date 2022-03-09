package Random;

import java.util.Date;

public class Flight {

    int flightId;
    String source;
    String destination;
    Date startTime;
    Date endTime;

    public Flight(int flightId, String source, String destination, Date startTime, Date endTime) {
        this.flightId = flightId;
        this.source = source;
        this.destination = destination;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
