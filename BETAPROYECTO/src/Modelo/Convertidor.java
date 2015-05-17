/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Calendar;

/**
 *
 * @author Iñigo
 */
public class Convertidor {
            public static java.sql.Time calendarToSqlTime(Calendar f) {
        java.sql.Time d = new java.sql.Time(f.getTimeInMillis());
        return d;

    }
        public static Calendar sqlTimeToCalendar(java.sql.Time f) {
        Calendar d = Calendar.getInstance();
        d.setTime(f);
        return d;
    }

        public static java.sql.Date calendarToSqlDate(Calendar f) {
        java.sql.Date d = new java.sql.Date(f.getTimeInMillis());
        return d;
    }

       public static Calendar sqlDateToCalendar(java.sql.Date f) {
        Calendar d = Calendar.getInstance();
        d.setTime(f);
        return d;
    }
}
