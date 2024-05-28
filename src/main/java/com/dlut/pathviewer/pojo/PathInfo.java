package com.dlut.pathviewer.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PathInfo {
    private int epoch;
    @JsonProperty("Threaten")
    private List<Building> Threaten;
    private List<List<Double>> path;

    @Data
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Building {
        @JsonProperty("Threaten_Type")
        private String ThreatenType;
        @JsonProperty("position")
        private Position position;
        @JsonProperty("_R")
        private double _R;
        @JsonProperty("_H")
        private double _H;

        @Data
        @NoArgsConstructor
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Position {
            @JsonProperty("x")
            private double x;
            @JsonProperty("y")
            private double y;
            @JsonProperty("z")
            private double z;
        }
    }
}
