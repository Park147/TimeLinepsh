package com.example.ch13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ch13.databinding.ActivityDetailBinding
import com.example.ch13.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 인텐트에 등록된 데이터 가져오기
            val data1 = intent.getStringExtra("data1")
        // 2번째 매개변수, 디폴트 값은 불로온 값이 없을 경우, 기본값이 대체됨.
            val data2 = intent.getIntExtra("data2",0)
        
        binding.resultViewText.text = "data1키의 값 조회: $data1, data2키의 값의 조회: $data2"

        // 후처리 작업 테스트.
        // 버튼을 클릭 시 , 후처리 작업.
        binding.btn2.setOnClickListener {
            //작업 set
            intent.putExtra("result","후처리 데이터 값")
            // 결과 코드와, 인텐트 전달작업
            setResult(RESULT_OK,intent)
            //현재 화면 종료.
            finish()
        }



    }
}