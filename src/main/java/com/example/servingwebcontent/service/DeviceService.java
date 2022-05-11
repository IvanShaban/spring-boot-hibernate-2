package com.example.servingwebcontent.service;

import com.example.servingwebcontent.repository.criteria.DeviceRepository;
import com.example.servingwebcontent.service.dto.DeviceCreateDto;
import com.example.servingwebcontent.service.dto.DeviceDto;
import com.example.servingwebcontent.repository.entity.Device;
import com.example.servingwebcontent.service.mapper.DeviceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DeviceService {
    private final DeviceRepository deviceRepository;

    public void create(DeviceCreateDto deviceCreateDto) {
        deviceRepository.save(DeviceMapper.INSTANCE.deviceCreateDtoToDevice(deviceCreateDto));
    }

    public List<DeviceDto> getAll() {
        return deviceRepository.findAll().stream()
                .map(DeviceMapper.INSTANCE::deviceToDeviceDto)
                .collect(Collectors.toList());
    }

    public DeviceDto getById(Long id) {
        Device device = deviceRepository.findById(id);
        return DeviceMapper.INSTANCE.deviceToDeviceDto(device);
    }

    public void update(DeviceDto deviceDto) {
        deviceRepository.save(DeviceMapper.INSTANCE.deviceDtoToDevice(deviceDto));
    }

    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }
}
