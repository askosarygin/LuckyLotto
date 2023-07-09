package com.andreykosarygin.data.db

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

private const val TABLE_NAME_POINTS_OPERATIONS = "points_operations"
private const val DATE = "date"
private const val POINTS_OPERATION = "points_operation"

@Entity(tableName = TABLE_NAME_POINTS_OPERATIONS)
data class PointsOperationDatabaseClass(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = DATE) val date: Long,
    @ColumnInfo(name = POINTS_OPERATION) val pointsOperation: Long
)

@Dao
interface PointsOperationsDAO {
    @Insert
    fun add(pointsOperationDatabaseClass: PointsOperationDatabaseClass)

    @Query("SELECT * FROM $TABLE_NAME_POINTS_OPERATIONS")
    fun getAll(): List<PointsOperationDatabaseClass>
}

@Database(entities = [PointsOperationDatabaseClass::class], version = 1, exportSchema = false)
abstract class PointsOperationsDatabase : RoomDatabase() {
    abstract fun PointsOperationsDAO(): PointsOperationsDAO
}