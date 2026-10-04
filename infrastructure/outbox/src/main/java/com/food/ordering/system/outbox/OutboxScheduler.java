package com.food.ordering.system.outbox;


/**
 * @dev : Ezekiel Eromosei
 * @date : 17 Aug, 2026
 */

public interface OutboxScheduler {

    void processOutboxMessage();
}
