/*
 * Copyright 2017 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.pocket.kotlin

import com.ivianuu.pocket.*
import com.ivianuu.pocket.impl.PocketBuilder
import io.reactivex.Scheduler

/**
 * Real fluent store builder
 */
class FluentRealPocketBuilder constructor(private val cache: Cache? = null,
                                          private val encryption: Encryption? = null,
                                          private val scheduler : Scheduler? = null,
                                          private val serializer: Serializer,
                                          private val storage: Storage) {

    fun build() : Pocket {
        val builder = PocketBuilder.builder()
        if (cache != null) {
            builder.cache(cache)
        }
        if (encryption != null) {
            builder.encryption(encryption)
        }
        if (scheduler != null) {
            builder.scheduler(scheduler)
        }
        builder.serializer(serializer)
        builder.storage(storage)
        return builder.build()
    }
}