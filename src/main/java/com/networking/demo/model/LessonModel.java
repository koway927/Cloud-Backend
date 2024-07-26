package com.networking.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Map;

public class LessonModel {
    private Long id;
    private String lesson;
    private List<String> analogy;
    private List<String> actual_logic;
    private List<String> explannation;
    private List<Node> nodes;
    private List<String> options;
    private Solutions solutions;

    public static class Node {
        private String label;
        private String color;
    }

    public static class Solutions {
        private List<String> nodes;
        private List<Edge> edges;


        public static class Edge {
            private String source;
            private String target;
            private String option;

        }
    }

}
