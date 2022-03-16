package com.example.studentmanagementver2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.studentmanagementver2.models.Student
import com.example.studentmanagementver2.models.StudentList
import studentmanagementver2.R


class StudentListAdapter(private val studentList: ArrayList<Student>) :
    RecyclerView.Adapter<StudentListAdapter.ViewHolder>(){
    var onItemClick: ((Student) -> Unit)? = null
//    private var myFilter: ItemFilter?= ItemFilter()
//    private var filteredData: ArrayList<Student> = ArrayList()

    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        val studentNameTV = listItemView.findViewById<TextView>(R.id.studentFullNameTV)
        val studentClassTV = listItemView.findViewById<TextView>(R.id.studentClassTV)
        val studentOtherInforTV = listItemView.findViewById<TextView>(R.id.studentOtherInfoTV)
        val studentAvatarIV = listItemView.findViewById<ImageView>(R.id.studentAvatarIV)

        init {
            listItemView.setOnClickListener {
                onItemClick?.invoke(studentList[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val studentView = inflater.inflate(R.layout.student_list_item, parent, false)
        return ViewHolder(studentView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student: Student = studentList[position]
        val studentNameTextView = holder.studentNameTV
        studentNameTextView.setText(student.name)
        val studentClassTextView = holder.studentClassTV
        studentClassTextView.setText(student.classroom)
        val studentOtherInforTextView = holder.studentOtherInforTV
        studentOtherInforTextView.setText(student.birthday + " - " + student.gender)
        val studentAvatarImageView = holder.studentAvatarIV
        studentAvatarImageView.setImageResource(R.drawable.student_avatar)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

//    override fun getFilter(): Filter? {
//        return myFilter
//    }
//    fun filterStudentByName(name: String): ArrayList<Student>{
//        this.getFilter()!!.filter(name)
//        return filteredData
//    }
//    private inner class ItemFilter: Filter(){
//        override fun performFiltering(p0: CharSequence?): FilterResults {
//            val results: FilterResults = FilterResults()
//            val foundStudents: ArrayList<Student> =
//                StudentList.getStudentList()
//                    .filter { s -> s.name.contains((p0.toString()), true) } as ArrayList<Student>
//            results.values = foundStudents
//            results.count = foundStudents.size
//            return results
//        }
//
//        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
//            filteredData = p1!!.values as ArrayList<Student>
//            notifyDataSetChanged()
//        }
//
//    }
}