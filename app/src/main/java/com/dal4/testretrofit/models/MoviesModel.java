package com.dal4.testretrofit.models;

import java.util.List;

public class MoviesModel {
    private List<MoveDetail> d;
    private String q;

    public MoviesModel(List<MoveDetail> d, String q) {
        this.d = d;
        this.q = q;
    }

    public class MoveDetail {
        private String id;
        private String l;
        private String q;

        public MoveDetail(String id, String l, String q) {
            this.id = id;
            this.l = l;
            this.q = q;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getL() {
            return l;
        }

        public void setL(String l) {
            this.l = l;
        }

        public String getQ() {
            return q;
        }

        public void setQ(String q) {
            this.q = q;
        }
    }

    public List<MoveDetail> getD() {
        return d;
    }

    public void setD(List<MoveDetail> d) {
        this.d = d;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }
}
