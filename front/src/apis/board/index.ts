import axios from "axios";
import { PostBoardRequestDto } from "./dto/request";
import { GET_BOARD_LIST_URL, GET_SEARCH_BOARD_LIST_URL, POST_BOARD_REQUEST_URL } from "src/constant";
import { bearerAuthorization, requestErrorHandler, requestHandler } from "..";
import ResponseDto from "../response.dto";
import { GetBoardListResponseDto, GetSearchBoardListResponseDto,  } from "./dto/response";


// function : Q&A 작성 API 함수 
export const PostBoardRequest = async(requestBody: PostBoardRequestDto, accessToken: string) => {
    const result = await axios.post(POST_BOARD_REQUEST_URL, requestBody,bearerAuthorization(accessToken))
    .then(requestHandler<ResponseDto>)
    .catch(requestErrorHandler);
    return result;
}

// function : Q&A 전체 리스트 불러오기 API 함수
export const getBoardListRequest = async(accessToken: string) => { // 토큰을 포함해서 가져와야 함
    const result = await axios.get(GET_BOARD_LIST_URL,bearerAuthorization(accessToken))
    .then(requestHandler<GetBoardListResponseDto>) //위에 코드가 성공한다면 <GetBoardListResponseDto> 받을 것이고
    .catch(requestErrorHandler); // 실패한다면 에러
    return result;

}

// function : Q&A 검색 리스트 불러오기 API 함수
export const getSearchBoardListRequest = async(searchWord:string, accessToken:string) => { //searchWord 먼저 받고 ,accessToken 받기
    const result = await axios.get(GET_SEARCH_BOARD_LIST_URL(searchWord),bearerAuthorization(accessToken))
    .then(requestHandler<GetSearchBoardListResponseDto>) // 성공
    .catch(requestErrorHandler); // 실패
    return result;


};