package com.marsRovers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PositionTest {
    Rover rover;
    Plateau plateau;
    Position position;
    @BeforeEach
    public void setUp(){
        rover = new Rover(position,new ArrayList(Arrays.asList("M", "L")));
        plateau = new Plateau(1,1);
        position = new Position(0,0,'S');
    }
    @Test
    public void exceed_South_Limit_should_return_true_when_y_value_is_zero(){
        Assertions.assertEquals(true, position.exceedSouthLimit());
    }

    @Test
    public void exceed_North_Limit_should_return_true_when_y_value_is_1(){
        position.setY(1);
        Assertions.assertEquals(true, position.exceedNorthLimit(plateau));
    }

    @Test
    public void exceed_East_Limit_should_return_true_when_x_value_is_1(){
        position.setX(1);
        Assertions.assertEquals(true, position.exceedEastLimit(plateau));
    }

    @Test
    public void exceed_West_Limit_should_return_true_when_y_value_is_1(){
        Assertions.assertEquals(true, position.exceedWestLimit());
    }
}