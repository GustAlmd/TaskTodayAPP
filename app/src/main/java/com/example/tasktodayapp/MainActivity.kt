package com.example.tasktodayapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tasktodayapp.ui.theme.TaskTodayAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenContent()
            }
        }
    }

@Composable
fun MainScreenContent() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,

        topBar = {
            TopAppBar(

                title = { Text(text = "TaskTodayApp")},
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch{
                            scaffoldState.drawerState.open()
                        }
                    } ){
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Drawer Menu",
                            tint = Color(0xFFE6E6FA),

                        )
                    }
                },

                backgroundColor = Color(0xFF7B68EE )
            )


        },

        drawerBackgroundColor = Color(0xFF7B68EE),
        drawerGesturesEnabled = scaffoldState.drawerState.isOpen,

        drawerContent = {
            Box(
                modifier = Modifier
                    .height(16.dp)
            ){
                    Text(text = "Em Desenvolvimento !!!")
            }


        },

        content = {

            paddingValues -> Log.i("paddinVales", "$paddingValues")
            Column(
                modifier = Modifier
                    .background(Color(0xFFFFFAFA ))
                    .fillMaxSize()
            ) {
                MySearchField(modificador = Modifier.fillMaxWidth())
                MyTaskWidget(
                    modificador = Modifier.fillMaxWidth(),
                    taskName = "Atividade de Portugues",
                    taskDetails = "Pesquisa sobre os Heteronomios de Fernando Pessoa",
                    deadEndDate = Date()
                )
                MyTaskWidget(
                    modificador = Modifier.fillMaxWidth(),
                    taskName = "Prova Matemática",
                    taskDetails = "Estudar Log e Trigonometria",
                    deadEndDate = Date()
                )

                MyTaskWidget(
                    modificador = Modifier.fillMaxWidth(),
                    taskName = "Prova Quimica",
                    taskDetails = "Estudar sobre elementos quimico e ionização",
                    deadEndDate = Date()
                )

                MyTaskWidget(
                    modificador = Modifier.fillMaxWidth(),
                    taskName = "Prova Biologia",
                    taskDetails = "Estudar sobre biodiversidade e biosfera",
                    deadEndDate = Date()
                )

                MyTaskWidget(
                    modificador = Modifier.fillMaxWidth(),
                    taskName = "Prova Historia",
                    taskDetails = "Estudar sobre a guerra fria",
                    deadEndDate = Date()
                )
            }
        },

        bottomBar = {

                BottomAppBar(
                    content = {Text("©Gustavo de Almeida, 2023",
                    fontWeight = FontWeight.Bold)},
                    backgroundColor = Color(0xFF7B68EE ),
                )
        }
    )
    }

@Composable
fun MySearchField(modificador: Modifier){
    TextField(
        value = "",
        onValueChange = {},
        modifier = modificador,
        placeholder = { Text(text = "Pesquisar atividades")},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = Color(0xFF000000),
            )
        }
    )
}


@Composable
fun MyTaskWidget(
        modificador: Modifier,
        taskName: String,
        taskDetails: String,
        deadEndDate: Date
    ){
    val dateFormatter = SimpleDateFormat("EEE, MMM dd, yyyy", Locale.getDefault())
    Row(modifier = modificador) {
        Icon(
            imageVector = Icons.Default.Notifications,
            tint = Color(0xFFFFD700),
            contentDescription = "Icons  of a pendent taks"
        )

        Text(
            text = dateFormatter.format(deadEndDate),
            fontSize = 12.sp,
            color = Color(0xFF483D8B),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic
        )

        Column(
            modifier = modificador
                .border(width = 1.dp, color = Color.Black)
                .padding(3.dp)
                .background(Color(0xFF8470FF))

        ) {
            Text(
                text = taskName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                color = Color(0xFF000000)
            )
            Text(
                text = taskDetails,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                fontStyle = FontStyle.Normal,
                color = Color(0xFFFFFAFA)
            )
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}
//@Preview(showBackground = true)