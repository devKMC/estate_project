import React from 'react';
import './style.css'

//              component               //
export default function QnaDetail() {

    //              render               //
    return (
        <div id = 'qna-detail-wrapper'>
            <div className='qna-detail-main-box'>
                <div className='qna-detail-top-box'>
                    <div className='qna-detail-title-box'>제목 입니다.</div>
                    <div className='qna-detail-info-box'>
                        <div className='qna-detail-info'>작성자 k********</div>
                        <div className='qna-detail-info-divider'>{'\|'}</div>
                        <div className='qna-detail-info'>작성일 2024.05.07</div>
                        <div className='qna-detail-info-divider'>{'\|'}</div>
                        <div className='qna-detail-info'>조회수 1</div>
                    </div>
                </div>
                <div className='qna-detail-contents-box'>내용입니다.</div>
            </div>
            <div className='qna-detail-comment-write-box'>
                <div className='qna-detail-comment-textarea-box'>
                    <textarea className='qna-detail-comment-texarea' placeholder='답글을 작성해주세요.' />
                </div>
                <div className='primary-button'></div>
            </div>
            <div className='qna-detail-comment-box'>
                <div className='primary-bedge'>답변</div>
                <div className='qna-detal-comment'>답변입니다</div>
            </div>
            <div className='qna-detail-button-box'>
                <div className='primary-button'>목록보기</div>
                <div className='qna-detail-owner-button-box'>
                    <div className='secont-button'>수정</div>
                    <div className='error-button'>삭제</div>
                </div>
            </div>
        </div>
    );
}
