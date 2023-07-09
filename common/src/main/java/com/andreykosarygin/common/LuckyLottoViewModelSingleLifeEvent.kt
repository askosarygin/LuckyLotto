package com.andreykosarygin.common

import java.util.concurrent.atomic.AtomicBoolean

open class LuckyLottoViewModelSingleLifeEvent<EVENT>(
    private val event: EVENT
) : LuckyLottoViewModelEvent<EVENT>(event) {
    private val processed = AtomicBoolean(false)

    override fun use(doEvent: (EVENT) -> Unit) {
        if (!processed.getAndSet(true)) {
            super.use(doEvent)
        }
    }
}