package org.hao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class TimeController {

    public ObservableList<String> loadTZDB(){
        List<String> zones = convertSetToList(ZoneId.getAvailableZoneIds());

        ArrayList<String>  zonesAL = zones.stream()
                .sorted()
                .filter(s->s.contains("/"))
                .collect(Collectors.toCollection(ArrayList::new));
        ObservableList<String> list  =FXCollections.observableArrayList(zonesAL);
        return list;

    }



    public static <T> List<T> convertSetToList(Set<T> set)
    {
        // create an empty list
        List<T> list = new ArrayList<>();

        // push each element in the set into the list
        for (T t : set)
            list.add(t);

        // return the list
        return list;
    }


}
