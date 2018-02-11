package tech.spaceoso.dasboot.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.spaceoso.dasboot.model.Shipwreck;
import tech.spaceoso.dasboot.repository.ShipwreckRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class ShipwreckController {

    @Autowired
    private ShipwreckRepository shipwreckRepository;

    /**
     * You are telling Spring boot to create wrappers to call methods on ShipwreckStub.
     * Methods will look like this:
     * ShipwreckController.list()
     * ShipwreckController.create()
     * ShipwreckController.get()
     */
    @RequestMapping(value = "shipwrecks", method = RequestMethod.GET)
    public List<Shipwreck> list() {
        return shipwreckRepository.findAll();
    }

    @RequestMapping(value = "shipwrecks", method = RequestMethod.POST)
    public Shipwreck create(@RequestBody Shipwreck shipwreck) {

        return shipwreckRepository.saveAndFlush(shipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.GET)
    public Shipwreck get(@PathVariable long id) {
        return shipwreckRepository.findOne(id);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.PUT)
    public Shipwreck update(@PathVariable long id, @RequestBody Shipwreck shipwreck) {
        Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
        BeanUtils.copyProperties(shipwreck, existingShipwreck);
        return shipwreckRepository.saveAndFlush(existingShipwreck);
    }

    @RequestMapping(value = "shipwrecks/{id}", method = RequestMethod.DELETE)
    public Shipwreck delete(@PathVariable long id) {
        Shipwreck existingShipwreck = shipwreckRepository.findOne(id);
        shipwreckRepository.delete(existingShipwreck);
        return existingShipwreck;
    }

}