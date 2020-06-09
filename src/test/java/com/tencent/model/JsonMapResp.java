package com.tencent.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class JsonMapResp {
    List<Map<String,Object>> list;
 }
