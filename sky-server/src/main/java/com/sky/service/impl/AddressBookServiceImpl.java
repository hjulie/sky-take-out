package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.entity.AddressBook;
import com.sky.mapper.AddressBookMapper;
import com.sky.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBookMapper addressBookMapper;

    //新增地址
    public void save(AddressBook addressBook) {
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBook.setIsDefault(0);
        addressBookMapper.insert(addressBook);
    }

    //查询当前登录用户的所有地址信息
    public List<AddressBook> list(AddressBook addressBook) {
        return addressBookMapper.list(addressBook);
    }

    //根据id修改地址
    public void update(AddressBook addressBook) {
        addressBookMapper.update(addressBook);
    }

    //设置默认地址
    public void setDefault(AddressBook addressBook) {
        //1.将当前用户的所有地址修改为非默认地址
        addressBook.setIsDefault(0);
        addressBook.setUserId(BaseContext.getCurrentId());
        addressBookMapper.updateIsDefaultByUserId(addressBook);

        //2.将当前地址改为默认地址
        addressBook.setIsDefault(1);
        addressBookMapper.update(addressBook);

    }

    //根据id删除地址
    public void deleteById(Long id) {
        addressBookMapper.deleteById(id);
    }

    //根据id查询地址
    public AddressBook getById(Long id) {
        AddressBook addressBook = addressBookMapper.getById(id);
        return addressBook;
    }


}
