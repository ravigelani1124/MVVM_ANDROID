package com.learning.data.model

import com.google.gson.annotations.SerializedName
import com.learning.domain.model.Error

internal data class ErrorData(

    @SerializedName("status_code")
    val statusCode: Int?,
    @SerializedName("status_message")
    val message: String?
)

internal fun ErrorData.map(): Error {

    return com.learning.domain.model.Error(
        statusCode = this.statusCode,
        message = this.message
    )

}