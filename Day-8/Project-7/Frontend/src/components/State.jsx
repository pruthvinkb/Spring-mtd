import { useState } from "react";
function State() {
    const [count, setCount] = useState(true);

    const switchFunction = () => {
        setCount(!count);
    };

    return (
        <div>
            {count && <div>Count is True</div>}
            {!count && <div>Count is False</div>}
            <button onClick={switchFunction}>Switch</button>
        </div>
    );
}
export default State;