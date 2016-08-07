package org.coder.lucky.lombok.model;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: coderbyluck
 * Date: 8/6/16
 * Time: 5:33 PM
 * File Description:
 */
@lombok.Data
@RequiredArgsConstructor
public class Data {
    @NonNull
    private UUID id;
    @NonNull
    private String action;


}
