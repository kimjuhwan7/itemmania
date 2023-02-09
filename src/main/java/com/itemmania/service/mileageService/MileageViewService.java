package com.itemmania.service.mileageService;

import com.itemmania.domain.mileage.MyMileageDetailDTO;
import com.itemmania.domain.mileage.MyMileageDetailRequest;
import com.itemmania.entity.MileageEntity;
import com.itemmania.mapper.MileageMapper;
import com.itemmania.repository.MileageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class MileageViewService {

    @Autowired
    private MileageMapper mileageMapper;

    @Autowired
    private MileageRepository mileageRepository;

    public int getUserMileage(Integer userNum){
        return mileageMapper.getMileageCount(userNum);
    }

    public List<MyMileageDetailDTO> getMileageHistory(MyMileageDetailRequest myMileageDetailRequest){

        List<MyMileageDetailDTO> historyList = new ArrayList<>();
        List<MileageEntity> mileageList = mileageRepository.findByUserNum_UserNum(myMileageDetailRequest.getUserNum());

        mileageList.sort(Comparator.comparing(MileageEntity::getMileageTime));

        for(int i=0; i<mileageList.size(); i++){
            MyMileageDetailDTO myMileageDetailDTO = new MyMileageDetailDTO();
            myMileageDetailDTO.setMileageEntity(mileageList.get(i));

            if (i == 0){
                myMileageDetailDTO.setMileageHistory(0);
            } else {
                myMileageDetailDTO.setMileageHistory(historyList.get(i-1).getMileageHistory() + mileageList.get(i).getMileageIn() - mileageList.get(i).getMileageOut());
            }

            historyList.add(myMileageDetailDTO);
        }

        List<MyMileageDetailDTO> result = new ArrayList<>();

//        historyList.sort(Comparator.comparing(MyMileageDetailDTO.mileageEntity::getMileageTime).reversed());
//        for(int i=historyList.size(); i>=0; i--){
//            result.add(historyList.get(i));
//        }

        for(MyMileageDetailDTO myMileageDetailDTO : historyList){

            if( myMileageDetailDTO.getMileageEntity().getMileageTime().isAfter(myMileageDetailRequest.getStartDate()) && myMileageDetailDTO.getMileageEntity().getMileageTime().isBefore(myMileageDetailRequest.getEndDate()) ) {
                result.add(myMileageDetailDTO);
            }

        }

        for(int i=0; i<result.size(); i++){
            for(int j=0; j<result.size(); j++){

                if( result.get(i).getMileageEntity().getMileageTime().isBefore(result.get(j).getMileageEntity().getMileageTime()) && i<j && i!=j){
                    MyMileageDetailDTO myMileageDetailDTO = result.get(i);
                    result.set(i, result.get(j));
                    result.set(j, myMileageDetailDTO);
                }

            }
        }

        return result;
    }

}