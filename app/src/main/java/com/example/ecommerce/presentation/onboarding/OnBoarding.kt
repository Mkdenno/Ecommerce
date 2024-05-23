package com.example.ecommerce.presentation.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ecommerce.R
import com.example.ecommerce.ui.theme.EcommerceTheme

@Composable
fun OnBoarding(
    modifier: Modifier = Modifier, navigateToHome: () -> Unit
) {

    Box(
        modifier.fillMaxSize()

    ) {
        Image(
            painter = painterResource(id = R.drawable.v8),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {

            Column(
                modifier = Modifier.align(Alignment.BottomCenter),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally


            ) {
                Text(
                    text = "LIVE YOUR ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "PERFECT ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    color = Color.White,
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Smart, gorgeous & fashionable collection makes you cool",
                    color = Color.White,
                    textAlign = TextAlign.Center

                    )

                Button(
                    onClick = {
                        navigateToHome()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color.Red)


                ) {
                    Text(text = "START")
                }
            }


        }


    }


}


@Preview(
    showBackground = true, heightDp = 600, widthDp = 350
)
@Composable
fun OnBoardingPreview() {
    EcommerceTheme {
        OnBoarding {

        }
    }
}


