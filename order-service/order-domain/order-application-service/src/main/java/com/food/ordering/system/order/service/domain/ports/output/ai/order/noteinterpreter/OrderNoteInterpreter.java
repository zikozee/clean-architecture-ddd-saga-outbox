package com.food.ordering.system.order.service.domain.ports.output.ai.order.noteinterpreter;


import com.food.ordering.system.order.service.domain.valueobject.OrderPreferences;

/**
 * @dev : Ezekiel Eromosei
 * @date : 29 Jun, 2026
 */

public interface OrderNoteInterpreter {

    OrderPreferences interpret(String orderNote);
}
