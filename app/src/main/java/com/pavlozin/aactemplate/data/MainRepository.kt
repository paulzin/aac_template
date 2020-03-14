package com.pavlozin.aactemplate.data

class MainRepository private constructor(private val mainDao: MainDao) {
    fun getData() = mainDao.getMainModel()

    suspend fun createData(data: String) {
        val mainModel = MainModel(string = data)
        mainDao.insertMainModel(mainModel)
    }

    suspend fun removeData() {
        mainDao.deleteAll()
    }

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: MainRepository? = null

        fun getInstance(mainDao: MainDao) =
            instance ?: synchronized(this) {
                instance ?: MainRepository(mainDao).also { instance = it }
            }
    }
}