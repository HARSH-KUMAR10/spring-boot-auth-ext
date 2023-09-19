package com.harshkumar093.jpa.payload.request;

import com.harshkumar093.jpa.model.module.Module;

import java.util.ArrayList;

public class AddModulesRequest {
    public String userId;
    public ArrayList<Long> moduleIds;
}
