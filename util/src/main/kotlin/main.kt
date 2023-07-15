import java.io.File
import java.util.ArrayList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ro.kofe.model.*
import java.util.concurrent.CopyOnWriteArrayList




fun main(args: Array<String>) {
    removeDupes(findDupes())
    checkForUnassociatedMoves()
    checkForUnassociatedChars()
}

fun removeDupes(dupes:List<Pair<Move,Move>>){
    val gson = Gson()
    val charType = object: TypeToken<ArrayList<Character>>() {}.type
    val moveType = object: TypeToken<ArrayList<Move>>() {}.type
    val oldMovesFile = File("/Users/mdrew/workspace/java/kofero-util/src/main/kotlin/oldMove.json")
    val oldCharsFile = File("/Users/mdrew/workspace/java/kofero-util/src/main/kotlin/oldChar.json")
    val newMovesFileWriter = File("/Users/mdrew/workspace/java/kofero-util/src/main/kotlin/newMove.json").bufferedWriter()
    val newCharsFileWriter = File("/Users/mdrew/workspace/java/kofero-util/src/main/kotlin/newChar.json").bufferedWriter()


    val oldChars = gson.fromJson<ArrayList<Character>>(oldCharsFile.bufferedReader().readText(), charType)
    val oldMoves = gson.fromJson<ArrayList<Move>>(oldMovesFile.bufferedReader().readText(), moveType)
    var newChars = ArrayList<Character>()
    var newMoves = ArrayList<Move>()
    for(char in oldChars){
        val mutableMoveIds = char.moveIds.toMutableList()
        for(dupe in dupes){
            val smaller = if(dupe.first.uid < dupe.second.uid){ dupe.first } else{ dupe.second }
            val larger = if(smaller == dupe.first){dupe.second}else{dupe.first}
            if(char.moveIds.contains(larger.uid)){
                val index = char.moveIds.indexOf(larger.uid)
                mutableMoveIds.removeAt(index)
                mutableMoveIds.add(index,smaller.uid)
            }
        }
        newChars.add(Character(char.uid,char.name,char.attributes,mutableMoveIds,char.iconUrl))
    }
    for(move in oldMoves){
        var isDupe = false
        for(dupe in dupes){
            val larger = if(dupe.first.uid > dupe.second.uid){ dupe.first } else{ dupe.second }
            isDupe = larger.uid == move.uid || isDupe
        }
        if(!isDupe){ newMoves.add(move) }
    }
    newCharsFileWriter.write(gson.toJson(newChars))
    newCharsFileWriter.close()
    newMovesFileWriter.write(gson.toJson(newMoves))
    newMovesFileWriter.close()
}

fun checkForUnassociatedChars(){
    val gson = Gson()
    val gameType = object : TypeToken<ArrayList<Game>>() {}.type
    val charType = object : TypeToken<ArrayList<Character>>() {}.type
    val gamesFile = File("/Users/mdrew/workspace/java/kofero-util/src/main/kotlin/oldGame.json")
    val charsFile = File("/Users/mdrew/workspace/java/kofero-util/src/main/kotlin/oldChar.json")
    val games = gson.fromJson<ArrayList<Game>>(gamesFile.bufferedReader().readText(), gameType)
    val chars = gson.fromJson<ArrayList<Character>>(charsFile.bufferedReader().readText(),charType)
    var charIdsFromGames = HashSet<Int>()
    var charIdsFromChars = HashSet<Int>()
    for(game in games){
        for(id in game.charIds){
            charIdsFromGames.add(id)
        }
    }
    for(char in chars){
        charIdsFromChars.add(char.uid)
    }

    for(charId in charIdsFromChars){
        if(!charIdsFromGames.contains(charId)){
            println("HELLO: $charId")
        }
    }
    for(charId in charIdsFromGames){
        if(!charIdsFromChars.contains(charId)){
            println("Im in a game charset but not declared: $charId")
        }
    }
}


fun checkForUnassociatedMoves(){
    val charType = object : TypeToken<ArrayList<Character>>() {}.type
    val moveType = object : TypeToken<ArrayList<Move>>() {}.type
    val gson = Gson()
    val movesFile = File("/Users/mdrew/workspace/java/kofero-util/src/main/kotlin/oldMove.json")
    val charsFile = File("/Users/mdrew/workspace/java/kofero-util/src/main/kotlin/oldChar.json")
    val moves = gson.fromJson<ArrayList<Move>>(movesFile.bufferedReader().readText(), moveType)
    val chars = gson.fromJson<ArrayList<Character>>(charsFile.bufferedReader().readText(), charType)
    var movesIdSet = HashSet<Int>()
    var charMovesIdSet = HashSet<Int>()
    for(move in moves){
        movesIdSet.add(move.uid)
    }
    for(char in chars){
        for(charMove in char.moveIds){
            charMovesIdSet.add(charMove)
        }
    }
    for(moveId in movesIdSet){
        if(!charMovesIdSet.contains(moveId)){
            println("HELLO: $moveId")
        }
    }
    for(charId in charMovesIdSet){
        if(!movesIdSet.contains(charId)){
            println("Im in a character moveset but not declared: $charId")
        }
    }
}

fun findDupes():List<Pair<Move,Move>>{
    var pairs = CopyOnWriteArrayList<Pair<Move,Move>>()
    val fileList = ArrayList<File>()
    val objList = ArrayList<Obj>()
    val gson = Gson()
    val objType = object : TypeToken<ArrayList<Obj>>() {}.type
    val moveType = object : TypeToken<ArrayList<Move>>() {}.type
    val moveFile = File("/Users/mdrew/workspace/java/kofero-util/src/main/kotlin/oldMove.json")
    fileList.add( File("/Users/mdrew/workspace/java/kofero-util/src/main/kotlin/oldChar.json") )
    fileList.add( File("/Users/mdrew/workspace/java/kofero-util/src/main/kotlin/oldGame.json") )
    fileList.add( moveFile )
    for (file in fileList){
        val json = file.bufferedReader().readText()
        val iObjList = gson.fromJson<ArrayList<Obj>>(json, objType)
        objList.addAll(iObjList)
    }
    val json = moveFile.bufferedReader().readText()
    val moveList = gson.fromJson<ArrayList<Move>>(json,moveType)
    for(move in moveList){
        val newList = ArrayList(moveList)
        newList.remove(move)
        for(compMove in newList){
            if(moveEquals(move,compMove)){
                pairs.add(Pair(move,compMove))
            }
        }
    }
    var retPairs = ArrayList<Pair<Move,Move>>()
    for(pair in pairs){
        pairs.remove(pair)
        for(compPair in pairs){
            if(pairEquals(pair,compPair) && !containsPair(retPairs,pair)){
                retPairs.add(pair)
            }
        }
    }
    return retPairs
}

fun containsPair(pairs:List<Pair<Move,Move>>, pair:Pair<Move,Move>):Boolean {
    return pairs.contains(pair) || pairs.contains(Pair(pair.second,pair.first))
}

fun pairEquals(pairL:Pair<Move,Move>,pairR:Pair<Move,Move>): Boolean {
    return (pairL.first == pairR.first && pairL.second == pairR.second) || (pairL.first == pairR.second && pairL.second == pairR.first)

}

fun mapEquals(mapL:Map<String,String>,mapR:Map<String,String>):Boolean {
    for(key in mapL.keys){
        if(mapR[key] != mapL[key]){
            return false
        }
    }
    for(key in mapR.keys){
        if(mapL[key] != mapR[key]){
            return false
        }
    }
    return true
}

fun moveEquals(moveL:Move, moveR:Move):Boolean {
    if(moveL.name == moveR.name && mapEquals(moveL.attributes,moveR.attributes)) return true
    return false
}