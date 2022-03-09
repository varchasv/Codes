package Random;

import java.util.*;

public class FlightService {

    Map<String,Map<String,List<Integer>>> sourceDestMap = new HashMap<>();
    private Map<Integer,Flight> flightMap = new HashMap<>();

    public boolean addFlight(Flight flight){
        if(!flightMap.containsKey(flight.flightId)){

            if(sourceDestMap.containsKey(flight.source)){

                Map<String,List<Integer>> destinationFlightIdMap = sourceDestMap.get(flight.source);
                if(destinationFlightIdMap.containsKey(flight.destination)){
                    List<Integer> flightIdList = destinationFlightIdMap.get(flight.destination);
                    flightIdList.add(flight.flightId);
                    destinationFlightIdMap.put(flight.destination,flightIdList);
                }else{
                    List<Integer> flightIdList = new ArrayList<>();
                    flightIdList.add(flight.flightId);
                    destinationFlightIdMap.put(flight.destination,flightIdList);
                }
                sourceDestMap.put(flight.source,destinationFlightIdMap);

            }else{
                Map<String,List<Integer>> destToListMap = new HashMap<>();
                List<Integer> flightIdList = new ArrayList<>();
                flightIdList.add(flight.flightId);
                destToListMap.put(flight.destination,flightIdList);
                sourceDestMap.put(flight.source,destToListMap);
            }
            flightMap.put(flight.flightId,flight);
            return true;
        }
        return false;
    }


    public Flight deleteFlight(int flightId){
        /*
        if(flightMap.containsKey(flightId)){
            Flight flight = flightMap.get(flightId);
            flightMap.remove(flightId);
            flightList.remove(flight);
            return flight;
        }

         */
        return null;
    }
    public List<Flight> getFLightInOrderByStartTime(String source, String destination){

        List<Flight> flightListTemp = new ArrayList<>();

        if(sourceDestMap.containsKey(source)){

            Map<String ,List<Integer>> destFligtIdMap = sourceDestMap.get(source);


            if(destFligtIdMap.containsKey(destination)){
                List<Integer> flightIdList = destFligtIdMap.get(destination);



                for(int x : flightIdList){
                    Flight f = flightMap.get(x);
                    flightListTemp.add(f);
                }

                Collections.sort(flightListTemp, new Comparator<Flight>() {
                    @Override
                    public int compare(Flight f1, Flight f2) {
                        if(f1.startTime==f2.startTime){
                            return f1.endTime.compareTo(f2.endTime);
                        }
                        return f1.startTime.compareTo(f2.startTime);
                    }
                });


            }


            return flightListTemp;

        }

        return flightListTemp;

    }


}
