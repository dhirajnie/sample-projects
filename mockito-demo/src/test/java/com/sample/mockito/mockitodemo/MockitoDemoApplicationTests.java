package com.sample.mockito.mockitodemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith (SpringRunner.class)
@SpringBootTest
public class MockitoDemoApplicationTests
{
    @Mock
    DataService dataServiceMock;

    @InjectMocks
    BussinessServiceImpl bussinessService;


    @Test
    public void contextLoads()
    {
        //DataService dataServiceMock = mock( DataService.class );
        when( dataServiceMock.retrieveAllData() ).thenReturn( new int[] { 1, 2, 3, 4 } );
        int result = bussinessService.findTheGreatestFromAllData();
        assertEquals( 1, result );

    }


    @Test
    public void testSize()
    {
        List<Integer> listMock = mock( List.class );
        when( listMock.size() ).thenReturn( 10 );
        assertEquals( 10, listMock.size() );

    }


}
