package com.subhan.mvvmsampleapp.view


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.subhan.mvvmsampleapp.viewModel.HomeViewModel
import java.util.Locale


@Composable
fun HomePage(viewModel: HomeViewModel) {
    var cityName by remember { mutableStateOf("") }
    val tempData = viewModel.tempData.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = cityName,
            onValueChange = { cityName = it },
            label = { Text("Enter City Name") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if (cityName.isNotBlank()) {
                viewModel.getTemp(cityName)
            }
        }) {
            Text("Get Weather")
        }

        Spacer(modifier = Modifier.height(24.dp))

        tempData.value?.temperature?.let {
            val formatted=String.format(Locale.US,"%.1f", it)
            Text("Current Temperature: $formatted°C")
        } ?: Text("No data yet")

        tempData.value?.description?.let {
            Text("Description: $it")
        } ?: ""
    }
}
