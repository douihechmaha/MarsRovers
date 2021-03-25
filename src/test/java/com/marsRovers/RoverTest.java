package com.marsRovers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class RoverTest {
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
    public void move_should_throw_Exception_when_position_is_bottom_left_of_plateau_and_direction_is_south() throws Exception {
        Assertions.assertThrows(IndexOutOfBoundsException.class,()->rover.move(position, plateau));
    }

    @Test
    public void direction_is_set_to_East_when_rotate_left_is_called_on_direction_South(){
        rover.rotateLeft(position);
        Assertions.assertEquals('E',position.getDirection() );

    }



}