/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import tugas_2sc3.Zodiac_app;

@RunWith (Parameterized.class)
public class dateTesting {
    private int EXbulan, EXtanggal, EXtahun, EXCtahun, expected;
    private String zodiak;
    public dateTesting(int EXtanggal, int EXbulan, int EXtahun, int EXCtahun, int expected, String zodiak ) {
        this.EXtanggal = EXtanggal;
        this.EXbulan = EXbulan;
        this.EXtahun = EXtahun;
        this.EXCtahun = EXCtahun;
        this.expected = expected;
        this.zodiak = zodiak;

    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
 @Parameterized.Parameters
    public static Collection<Object[]> checknum(){
        Object[][]input;
        input = new Object[][]{{4,5,2018,1999,19,"Taurus"},{22,1,2018,1999,19,"Aquarius"},{4,5,2018,2000,18,"Taurus"}};
        return Arrays.asList(input);
    }
    @Test
    public void testUmur(){
        System.out.println("Check!");
        Zodiac_app za = new Zodiac_app();
        String actual = za.zodiak(EXtahun, EXCtahun, EXtanggal, EXbulan);
        assertEquals(expected, za.umur);
   
}
    @Test
    public void testZodiak(){
        System.out.println("Check!");
        Zodiac_app za = new Zodiac_app();
        String actual = za.zodiak(EXtahun, EXCtahun, EXtanggal, EXbulan);
        assertEquals(zodiak, actual);
   
}
}
    