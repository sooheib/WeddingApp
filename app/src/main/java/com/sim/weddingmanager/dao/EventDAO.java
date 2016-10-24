package com.sim.weddingmanager.dao;


import android.content.Context;

import com.sim.weddingmanager.entities.Event;

import garin.artemiy.sqlitesimple.library.SQLiteSimpleDAO;

/** TODO 10.1 CREATE THE DAO **/



public class EventDAO extends SQLiteSimpleDAO<Event>{


    public EventDAO(Class<Event> eventClass, Context context) {
        super(eventClass, context);
    }

}
