// SintefboardPortForward.h *** Connect ThingML ports to RCD ports .... sdalgard
//
#define RCD_PORT_IN_USE
// Place prototypes for /*PORT_NAME*/ here
void /*PORT_NAME*/_setup(void);
void /*PORT_NAME*/_set_listener_id(uint16_t id);
//void /*PORT_NAME*/_read(void);


struct /*PORT_NAME*/_instance_type {
    uint16_t listener_id;
    /*INSTANCE_INFORMATION*/
} /*PORT_NAME*/_instance;

