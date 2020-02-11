package com.itzidan.serviceImpl;

import com.itzidan.domain.SMail;
import com.itzidan.domain.User;
import com.itzidan.mapper.UserMapper;
import com.itzidan.service.UserService;
import com.itzidan.utils.MD5;
import com.itzidan.utils.SMTP_Mail;
import com.itzidan.utils.uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 注册新用户
     * @param user
     * @return
     */
    @Override
    public boolean addUser(User user) {
        //初始注册用户的部分信息
        user.setPwd(MD5.md5(user.getPwd()));
        user.setU_status(0);
        String userUUID = uuid.getShortUuid();
        user.setUuid(userUUID);
        try {
            userMapper.insertUser(user);
        } catch (DuplicateKeyException e) {
            //注册用户失败，用户不唯一
            return false;
        }

        SMail mail = new SMail();
        mail.setTo(user.getQq_mail());
        mail.setSubject("恭喜您！！！注册成功！！！");
        mail.setContent("账号注册成功，还需点击下方链接进行激活操作：http//localhost:8080/user/register?uuid="+user.getUuid());
        SMTP_Mail.send(mail);

        return true;
    }

    /**
     * 根据激活码激活账号
     * @param uuid  激活码
     * @return
     */
    @Override
    public boolean activateUser(String uuid) {
       String id= userMapper.selectUserByUUID(uuid);
       if (id==null||"".equals(id))
        return false;
     userMapper.updateStatusByUUID(uuid);

       return true;
    }
}
