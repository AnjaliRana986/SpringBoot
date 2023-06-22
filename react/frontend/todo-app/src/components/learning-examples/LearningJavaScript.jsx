const person = {
    name: 'Anjali Rana',
    address: {
        line1: 'Baker Street',
        city: 'London',
        Country: 'UK'
    },
    profile :['twitter','linkedin','instagram'],
    printprofile: () => {
        person.profile.map (
            (profile) => {
                console.log(profile)
            }
        )
        

    }
}


export default function LearningJavaScript() {
    return(
        <>
        <div>{person.name}</div>
        <div>{person.address.line1}</div>
        <div>{person.profile[0]}</div>
        <div>
            {person.printprofile()}
        </div>
        </>
    )
}