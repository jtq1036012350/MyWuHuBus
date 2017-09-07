package com.marsjiang.mywuhubus.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jiang on 2017-09-07.
 */

public class SearchBusWithBusNumResponse implements Serializable {

    public Result result;

    public class Result implements Serializable {

        public String upLine;
        public String downLine;
        public String price;
        public String interval;
        public String lineName;
        public String startendTime;
        public List<DownLineStationList> downLineStationList;

        public List<UpLineStationList> upLineStationList;

    }

    public class DownLineStationList implements Serializable{

    }

    public class UpLineStationList implements Serializable{

    }
}