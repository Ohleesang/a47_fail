package com.example.a47

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        class Solution {
            fun solution(strings: Array<String>, n: Int): Array<String> {
                var answer = Array<String>(strings.size,{""})
                // strings 의 n+1번째 문자를 꺼낸다
                // 그 꺼낸 문자의 순서를 구한다
                // 만약 문자가 똑같으면 사전순서대로 출력한다
                // 그 순서대로 다시 재정의 하여 출력 한다

                //1. index 가 n 인 문자열 꺼내기
                // 문자열하고 순번 둘다 정리하자
                // "문자열" "순서"
                var compare_Str = mutableListOf<Array<String>>()
                for(i in 0 .. strings.size-1) {
                    compare_Str.add(arrayOf<String>(strings[i].substring(n..n),"${i}"))
                }
                //2. 꺼낸 문자의 순서 구하기
                compare_Str.sortBy { it.first() }
                //문자가 똑같은지 판별 필요 --> 판별이후 인덱스값 불려서 비교후 순서변경
                var t = compare_Str[0][0]
                var exCompare_Str = mutableListOf<Array<String>>()
                for(i in 0..compare_Str.size-1){
                    if(compare_Str[i][0].equals(t)){
                        //같은경우 실행
                        exCompare_Str.add(compare_Str[i])
                        exCompare_Str[i][0] = strings[exCompare_Str[i][1].toInt()]
                    }
                    else{
                        //다른값 나오면 비교후 t값 초기화
                        exCompare_Str.sortBy { it.first() }
                        var s =exCompare_Str.size-i
                        for(j in 0..exCompare_Str.size-1){
                            compare_Str.set(s+j, arrayOf<String>(t,exCompare_Str[j][1]))
                        }
                        t = compare_Str[i][0]
                        exCompare_Str = mutableListOf<Array<String>>()
                    }
                }

                //3. answer 값에 입력
                for(i in 0 .. compare_Str.size-1){
                    answer[i]= strings[compare_Str[i][1].toInt()]
                }

                return answer
            }
        }
        val a = Solution()
        //a.solution(arrayOf<String>("sun","bed","car"),1)
        a.solution(arrayOf<String>("abcf","abce", "abcd", "cdx"),1)
    }

}