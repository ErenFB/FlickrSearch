package com.example.onboardingcompose.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.onboardingcompose.R
import com.example.onboardingcompose.com.example.onboardingcompose.util.PhotoItem

fun searchImages(query: String) {

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun HomeScreen() {
    var query by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    Box(

        modifier = Modifier.fillMaxSize() .background(Color(200,250,242)),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "HOME",
            fontSize = MaterialTheme.typography.h4.fontSize
        )
        SearchWidget(
            text = query,
            onTextChanged = { query = it },
            onSearchClicked = {
                searchImages(query)
                keyboardController?.hide()
                })
    }
}
@Composable
fun SearchWidget(
    text: String,
    onTextChanged: (String) -> Unit,
    onSearchClicked: (String) -> Unit
) {

    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(top=0.dp)
        ,
        elevation = 10.dp,
        color = Color(150,220,222)
    ) {

        TextField(
            value = text,
            onValueChange = { onTextChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester),
            placeholder = {
                Text(
                    text = "search", modifier = Modifier.alpha(
                        0.6f,
                    )
                )
            },
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = "search icon",
                        tint = Color.White
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (text.isNotEmpty())
                        onTextChanged("")

                }) {
                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "search icon",
                        tint = Color.White
                    )
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(onSearch = {
                onSearchClicked(text)
                focusManager.clearFocus()
            }),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                textColor = Color.White,
                cursorColor = Color.White
            )

        )

    }

}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StaggeredGridView(
    images: List<PhotoItem>,
    onImageClick: (PhotoItem) -> Unit,
    onHoldClick: ((PhotoItem) -> Unit)? = null
) {

    Column(

        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {

                        Column(

                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.CenterHorizontally),
                            horizontalAlignment = Alignment.CenterHorizontally
                        )
                        { //Image(
                           //     contentScale = ContentScale.Crop,
                           //     modifier = Modifier
                              // tiklandi ?      .combinedClickable(onClick = { onImageClick() },)

                           // )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(250.dp))
            }




