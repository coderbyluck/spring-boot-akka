package org.coder.lucky.lombok.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: coderbyluck
 * Date: 8/6/16
 * Time: 5:28 PM
 * File Description:
 */
@Data
public class Action {
    @NonNull
    private String command;

}
