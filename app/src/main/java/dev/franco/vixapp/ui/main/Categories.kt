package dev.franco.vixapp.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedFilterChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.franco.vixapp.ui.theme.VixAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun Categories(
    categories: List<String>,
    onClickCategory: () -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .testTag("categories")
            .layoutId("categories"),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(items = categories) { index, item ->
            ElevatedFilterChip(
                selected = index == categories.indices.first,
                onClick = onClickCategory,
                shape = RoundedCornerShape(50),
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = Color.Black,
                    labelColor = Color.LightGray,
                    selectedContainerColor = Color.Gray,
                ),
                border = FilterChipDefaults.filterChipBorder(
                    selectedBorderColor = Color.LightGray,
                ),
                label = {
                    Text(
                        text = item,
                        color = if (index == categories.indices.first) {
                            Color.White
                        } else {
                            Color.LightGray
                        },
                    )
                },
            )
        }
    }
}

@Preview
@Composable
private fun CategoriesPreview() {
    VixAppTheme {
        Categories(
            categories = listOf("Inicio", "Premium", "Drama"),
            onClickCategory = {},
        )
    }
}
