package com.example.api.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResultList<T> {

  List<T> results;
}
