package com.enigmacamp.simplejpa.utils;

import org.springframework.data.domain.Sort;

public class SortDirection {

    public Sort.Direction getSortDirection(String direction) {

        if(direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if(direction.equals("desc")) {
            return Sort.Direction.DESC;
        } else {
            return Sort.Direction.ASC;
        }
    }
}
