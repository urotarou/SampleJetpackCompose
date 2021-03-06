# Jetpack Compose サンプル

## Main

各Sampleへの導線

- Column
- Button, Text, Spacer
- 縦Scrollあり

## Sample ViewModel

ViewModel中のLiveDataと連携して値を表示へ反映

- Box
- Text, Button
- ViewModel

## Sample Image

画像を表示

- Column, Box
- Image, Spacer, Text

## Sample List

縦/横のリストを表示

- Box, LazyColumn, LazyRow, Row
- CircularProgressIndicator, Button, Text, Card
- ViewModel

## Sample Navigation

BottomNavigationを利用した画面切り替え

- NavHost, Column
- Text, Spacer, Button
- buildAnnotatedStringによる文字列の表示変更あり
- Buttonタップでのnavigateあり

## Sample Tab

タブを利用した表示切り替え

- Column, TabRow, Box
- Tab, Icon, Text

## Sample Drawer

ドロワーの表示とそれを利用した表示切り替え

- ModalDrawer, Column
- Text, Spacer, Button
- ButtonタップなどでのDrawerの開閉あり

## Sample Drawer

ConstraintLayoutを利用した表示

- ConstraintLayout
- Text

## Sample Message

ダイアログとスナックバーを表示

- Column, Box, Row
- Button, Text, Spacer, TextButton
- AlertDialog, Snackbar

## Sample BottomSheet

ボトムシートを表示

- ModalBottomSheetLayout, Box, Column
- Text, Button, Spacer

## Sample FAB

フローティングアクションボタンを表示

- Box
- Text
- 独自の関数BranchWithFabScreenにてFloatingActionButton利用あり

## Sample AndroidView

AndroidViewを利用してWebViewを表示

- Column
- AndroidView, Spacer, Text

## その他

土台づくりなどで共通利用しているものあり

- MaterialTheme, Scaffold
- TopAppBar, BottomNavigation, FloatingActionButton
- IconButton, BottomNavigationItem, Icon
- actionsによるオプション表示あり
- navigationIconによる画面戻りあり
