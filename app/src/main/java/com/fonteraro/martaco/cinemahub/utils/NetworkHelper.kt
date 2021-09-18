package com.fonteraro.martaco.cinemahub.utils

import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class NetworkHelper @Inject constructor(
    private val dispatcher: CoroutineDispatcher
) {

    suspend fun <T> safeApiCall(
        apiCall: suspend () -> T
    ): ResultWrapper<T> {
        return withContext(dispatcher) {
            try {
                ResultWrapper.Success(apiCall.invoke())
            } catch (e: IOException) {
                ResultWrapper.NetworkError(e.message)
            } catch (e: HttpException) {
                ResultWrapper.GenericError(e.message())
            } catch (e: IllegalStateException) {
                ResultWrapper.GenericError(e.message)
            }
        }
    }
}
