package com.example.basicnavigation_p14.database

class User (id:Int,username:String){
    val username =username
    val id= id
}
fun User.toEntity() = UserEntity(
    id,username
)