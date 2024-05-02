import React from 'react';
import './style.css'



export default function QnaWrite() {

     //                    render                    //
    return (
        <div id = "qna-write-wrapper">
            <div className= "qna-write-top">
                <div className='qna-write-title-box'>
                    <input/>
                </div>
                <div>올리기</div>
            </div>
            <div>
                {/*  두줄이상 작성할때 textarea 사용 */}
                <textarea /> 
            </div>
        </div>
    );
}
