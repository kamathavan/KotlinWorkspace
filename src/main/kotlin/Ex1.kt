import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


fun flowTest(request: Int): Flow<String> = flow {
    emit("First $request")
    delay(100)
    emit("Second $request")
}