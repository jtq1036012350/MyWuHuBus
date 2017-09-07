package com.marsjiang.mywuhubus.beans;

import java.io.Serializable;

/**
 * Created by Jiang on 2017-09-07.
 */

public class SearchLineWithBusNum implements Serializable {

    public String cmd;
    public Params params;

    public SearchLineWithBusNum() {

    }

    public SearchLineWithBusNum(String cmd, Params params) {
        this.cmd = cmd;
        this.params = params;
    }

    public class Params implements Serializable {
        public String lineName;

        public Params(String lineName) {
            this.lineName = lineName;
        }

        public String getLineName() {
            return lineName;
        }

        public void setLineName(String lineName) {
            this.lineName = lineName;
        }
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

}
